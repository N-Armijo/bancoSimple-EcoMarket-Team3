import React from "react";
import logo from '../../assets/logo.jpeg';
import cart from '../../assets/cart.svg';
import './Navbar.css';
import { Link } from "react-router-dom";

// Importamos el hook useTheme desde nuestro contexto de tema personalizado
import { useTheme } from "../../Context/themeContext";


export default function Navbar() {
  // Extraemos los valores del contexto de tema:
  // - darkMode: boolean que indica si el modo oscuro está activo
  // - toggleTheme: función para alternar entre temas
  // - colors: objeto con los colores del tema actual
  const { darkMode, toggleTheme, colors} = useTheme();

  return (
    <div
      className="navbar"
      style={{
        // Color de fondo según el tema
        backgroundColor: colors.navBar,
        // Sombra diferente para modo oscuro/claro
        boxShadow: darkMode
          ? "0 2px 4px rgba(0, 0, 0, 0.3)"
          : "0 2px 4px rgba(0, 0, 0, 0.1)",
      }}
    >
      {/* Logo */}
      <div className="nav-logo">
        <img src={logo} alt="logo" />
        
      </div>

      

      {/* Menú de navegación con color de texto dinámico */}
      <ul className="nav-menu"
        >
        <Link
          to={"/electrodomesticos"}
          style={{color:colors.text, textDecoration:"none"}}>
        <li style={{ color: colors.text }}>Electrodomesticos</li>
        </Link>
        <Link
          to={"/prendas"}
          style={{color:colors.text, textDecoration:"none"}}>
        <li style={{ color: colors.text }}>Prendas</li>
        </Link>
        <Link
          to={"/consumibles"}
          style={{color:colors.text, textDecoration:"none"}}>
        <li style={{ color: colors.text }}>Consumibles</li>
        </Link>
        
      </ul>

      {/* Contenedor de login/carrito/tema */}
      <div className="nav-login-cart">
        
      <img className="carrito-img" src={cart} alt="carrito" />
      
        <button
          style={{
            borderColor: colors.primary,
            color: colors.login,
            
          }}
        >
          Login
        </button>

        
        

        {/* Botón para alternar entre temas */}
        <button
          onClick={toggleTheme}
          style={{
            fontSize: "1.3rem",
            marginLeft: "1rem",
            padding: "0.5rem",
            background: "transparent",
            border: "1px solid",
            borderRadius: "50%",
            cursor: "pointer",
            color: colors.text, // Color de texto según el tema
          }}
          aria-label={
            darkMode ? "Cambiar a modo claro" : "Cambiar a modo oscuro"
          }
        >
          {darkMode ? "☀️" : "🌓"} {/* Icono solar o lunar según el tema */}
        </button>
      </div>
    </div>
  );
}

