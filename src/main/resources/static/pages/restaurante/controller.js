var backedCategoria = "http://localhost:8080/api/categorias";
var backedPlatillo = "http://localhost:8080/api/platillos";
var backedPedido = "http://localhost:8080/api/pedido";

// Inicialización
document.addEventListener('DOMContentLoaded', fetchCategories);

// Elementos del DOM
const categoriesList = document.getElementById('categories-list');
const dishesList = document.getElementById('dishes-list');
const orderList = document.getElementById('order-list');
const totalPriceElement = document.getElementById('total-price');
const purchaseBtn = document.getElementById('purchase-btn');
const selectedCategoryElement = document.getElementById('selected-category');

// Popup
const modal = document.getElementById('myModal');
const modalDishName = document.getElementById('modal-dish-name');
const modalDishDescription = document.getElementById('modal-dish-description');
const addToOrderBtn = document.getElementById('add-to-order-btn');
const closeModalBtn = document.getElementById('close-modal-btn');
const quantitySelect = document.getElementById('quantity');
const sizeRegular = document.getElementById('regular');
const sizeLarge = document.getElementById('grande');

let currentOrder = [];
let categories = [];

// Función para obtener categorías del servidor
async function fetchCategories() {
    try {
        const response = await fetch(`${backedCategoria}/listar`);
        categories = await response.json();
        renderCategories();
    } catch (error) {
        console.error('Error fetching categories:', error);
    }
}

// Función para obtener platillos por categoría del servidor
async function fetchDishes(categoryId) {
    try {
        const response = await fetch(`${backedPlatillo}/listar?categoriaId=${categoryId}`);
        const dishes = await response.json();
        renderDishes(dishes, categoryId);
    } catch (error) {
        console.error('Error fetching dishes:', error);
    }
}

// Función para renderizar categorías
function renderCategories() {
    categoriesList.innerHTML = '';
    categories.forEach(category => {
        const li = document.createElement('li');
        li.textContent = category.nombre;
        li.addEventListener('click', () => fetchDishes(category.id));
        categoriesList.appendChild(li);
    });
}

// Función para renderizar platillos
function renderDishes(dishes, categoryId) {
    const selectedCategory = categories.find(cat => cat.id === categoryId);
    selectedCategoryElement.textContent = selectedCategory ? selectedCategory.nombre : 'Seleccione una categoría';

    dishesList.innerHTML = '';
    dishes.forEach(dish => {
        const li = document.createElement('li');
        li.innerHTML = `
            <h4>${dish.nombre}</h4>
            <p>${dish.descripcion}</p>
            <p>Precio: $${dish.precio}</p>
            <button onclick="openModal('${dish.id}', '${dish.nombre}', '${dish.descripcion}', ${dish.precio})">Agregar</button>
        `;
        dishesList.appendChild(li);
    });
}

// Función para abrir el modal y mostrar detalles del platillo
function openModal(id, nombre, descripcion, precio) {
    modalDishName.textContent = nombre;
    modalDishDescription.textContent = descripcion;
    modal.style.display = 'block';

    // Configurar evento para el botón "Agregar a la Orden"
    addToOrderBtn.onclick = function() {
        addToOrder(id, nombre, precio);
        modal.style.display = 'none';
    }

    // Configurar evento para el botón "Cerrar"
    closeModalBtn.onclick = function() {
        modal.style.display = 'none';
    }

    // Cerrar el modal si se hace clic fuera de él
    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = 'none';
        }
    }
}

// Función para agregar platillo a la orden
function addToOrder(dishId, dishName, dishPrice) {
    const quantity = parseInt(quantitySelect.value);
    const size = sizeRegular.checked ? 'regular' : 'grande';
    const price = size === 'regular' ? dishPrice : dishPrice * 1.2; // Aplicar 20% extra para tamaño grande

    const existingDish = currentOrder.find(item => item.id === dishId && item.size === size);
    if (existingDish) {
        existingDish.quantity += quantity;
    } else {
        currentOrder.push({ id: dishId, nombre: dishName, precio: price, quantity: quantity, size: size });
    }
    updateOrder();
}

// Función para actualizar la orden
function updateOrder() {
    orderList.innerHTML = '';
    let total = 0;
    currentOrder.forEach(item => {
        const li = document.createElement('li');
        li.textContent = `${item.nombre} (${item.size}) x ${item.quantity} - $${item.precio * item.quantity}`;
        orderList.appendChild(li);
        total += item.precio * item.quantity;
    });
    totalPriceElement.textContent = total.toFixed(2);
}

// Función para enviar la orden al servidor
async function purchaseOrder() {
    // Verificar si currentOrder está vacío
    if (currentOrder.length === 0) {
        alert("No hay platillos en la orden. Agrega al menos un platillo antes de realizar la compra.");
        return; // Salir de la función si no hay platillos en el pedido
    }

    try {
        const response = await fetch(`${backedPedido}/crear`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(currentOrder)
        });
        const data = await response.text(); // Leer la respuesta como texto

        // Mostrar el mensaje de orden procesada (texto simple devuelto por el backend)
        alert(data);

        // Limpiar la sección de órdenes en la página
        currentOrder = [];
        updateOrder();

        // Actualizar visualmente la lista de platillos (limpiar)
        dishesList.innerHTML = '';

    } catch (error) {
        alert("Error al enviar la orden.");
        console.error(error);
    }
}




// Event listener para el botón de comprar
purchaseBtn.addEventListener('click', purchaseOrder);
