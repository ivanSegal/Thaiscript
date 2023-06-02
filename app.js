<!DOCTYPE html>
<html>
<head>
  <title>Sistema de Pedidos</title>
</head>
<body>
  <h1>Sistema de Pedidos</h1>

  <div id="loginScreen">
    <h2>Pantalla de Ingreso</h2>
    <!-- Formulario de ingreso -->
    <form id="loginForm">
      <!-- Campos de ingreso -->
      <input type="text" id="username" placeholder="Usuario" required>
      <input type="password" id="password" placeholder="Contraseña" required>
      <button type="submit">Ingresar</button>
    </form>
  </div>

  <div id="orderScreen" style="display: none;">
    <h2>Pantalla de Pedido</h2>
    <!-- Formulario de pedido -->
    <form id="orderForm">
      <h3>Forma de entrega</h3>
      <input type="radio" name="deliveryOption" value="local" required> Retiro en local
      <input type="radio" name="deliveryOption" value="domicilio" required> Envío a domicilio

      <h3>Datos de envío</h3>
      <input type="text" id="address" placeholder="Dirección">
      <input type="text" id="phone" placeholder="Teléfono">

      <h3>Forma de pago</h3>
      <input type="radio" name="paymentOption" value="efectivo" required> Efectivo
      <input type="radio" name="paymentOption" value="mercadoPago" required> Mercado Pago

      <button type="submit">Confirmar Pedido</button>
    </form>
  </div>

  <div id="orderSummary" style="display: none;">
    <h2>Resumen del Pedido</h2>
    <div id="items"></div>
    <div id="deliveryInfo"></div>
    <div id="paymentInfo"></div>
    <div id="orderTotal"></div>
    <button id="confirmOrder">Confirmar Pedido</button>
  </div>

  <script>
    document.addEventListener("DOMContentLoaded", function() {
      // Verificar si el usuario ha ingresado
      var isLoggedIn = false; // Variable para simular el estado de inicio de sesión

      if (!isLoggedIn) {
        // Redirigir al usuario a la pantalla de ingreso
        document.getElementById("loginScreen").style.display = "block";
      } else {
        // Mostrar la pantalla del pedido
        document.getElementById("orderScreen").style.display = "block";
      }

      // Evento de envío del formulario de ingreso
      document.getElementById("loginForm").addEventListener("submit", function(e) {
        e.preventDefault();
        // Realizar verificación de inicio de sesión aquí

        // Mostrar la pantalla del pedido después del inicio de sesión
        document.getElementById("loginScreen").style.display = "none";
        document.getElementById("orderScreen").style.display = "block";
      });

      // Evento de envío del formulario de pedido
      document.getElementById("orderForm").addEventListener("submit", function(e) {
        e.preventDefault();
        // Procesar el pedido aquí

        // Mostrar el resumen del pedido
        document.getElementById("orderScreen").style.display = "none";
        document.getElementById("orderSummary").style.display = "block";

        // Calcular tiempo estimado de entrega
        var estimatedTime = calculateEstimatedTime(); // Función a implementar

        // Mostrar el tiempo estimado de entrega
        document.getElementById("orderSummary").innerHTML += "<div>Tiempo estimado de entrega: " + estimatedTime + " minutos</div>";
      });

      // Evento de confirmación del pedido
      document.getElementById("confirmOrder").addEventListener("click", function() {
        // Descontar del stock de ingredientes
        updateStock(); // Función a implementar

        // Asignar el estado "A confirmar" al pedido
        assignOrderStatus(); // Función a implementar

        // Realizar el pago si se eligió Mercado Pago
        var paymentOption = document.querySelector('input[name="paymentOption"]:checked').value;
        if (paymentOption === "mercadoPago") {
          makeMercadoPagoPayment(); // Función a implementar
        }
      });
    });

    // Función para calcular el tiempo estimado de entrega
    function calculateEstimatedTime() {
      var itemTimes = [15, 20, 25]; // Ejemplo de tiempos estimados de los productos
      var maxItemTime = Math.max(...itemTimes);

      var cookingTimes = [30, 40, 50]; // Ejemplo de tiempos estimados de los pedidos en cocina
      var maxCookingTime = Math.max(...cookingTimes);

      var deliveryTime = 10; // Tiempo adicional de entrega para envío a domicilio

      return maxItemTime + maxCookingTime + (deliveryTime * (document.querySelector('input[name="deliveryOption"]:checked').value === "domicilio" ? 1 : 0));
    }

    // Resto de las funciones a implementar

    function updateStock() {
      // Implementar la lógica para descontar del stock de ingredientes
    }

    function assignOrderStatus() {
      // Implementar la lógica para asignar el estado "A confirmar" al pedido
    }

    function makeMercadoPagoPayment() {
      // Implementar la lógica para realizar el pago con Mercado Pago
    }
  </script>
</body>
</html>
