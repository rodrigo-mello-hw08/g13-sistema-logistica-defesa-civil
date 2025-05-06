document.addEventListener("DOMContentLoaded", function () {
    const form = document.querySelector("form");

    form.addEventListener("submit", function (event) {
        event.preventDefault(); // Impede envio real do formulário

        const email = document.getElementById("email").value;
        const senha = document.getElementById("password").value;

        if (email === "defesa@email.com" && senha === "defesa123") {
            window.location.href = "defesa.html";
        } else if (email === "usuario@email.com" && senha === "usuario123") {
            window.location.href = "usuario.html";
        } else {
            alert("Email ou senha inválidos!");
        }
    });
});
