package org.example.restaurante.presentation;

import org.example.restaurante.logic.Pedido;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    private AtomicInteger numeroConsecutivo = new AtomicInteger(1); // Usamos AtomicInteger para asegurar operaciones atómicas

    @PostMapping("/crear")
    public String crearOrden(@RequestBody List<Pedido> detallesPedido) {
        // Formatear el número consecutivo con relleno de ceros a 4 dígitos
        String numeroOrden = String.format("#%04d", numeroConsecutivo.getAndIncrement());

        String mensaje = "Orden creada exitosamente. \n Su número de orden: " + numeroOrden;
        System.out.println("Orden: " + numeroOrden);
        for (Pedido detalle : detallesPedido) {
            System.out.println(detalle.getQuantity() + " x " + detalle.getNombre() + " - " + detalle.getSize() );
        }

        return mensaje;
    }
}
