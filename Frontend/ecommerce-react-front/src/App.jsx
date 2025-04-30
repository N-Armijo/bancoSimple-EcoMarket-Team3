import './App.css'
import Nosotros from './components/Nosotros/Nosotros.jsx'
import Navbar from './components/Navbar/Navbar.jsx'
import { ThemeProvider } from './Context/themeContext.jsx';
import Footer from './components/Footer/Footer.jsx';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

import Electronica from './pages/Electronica.jsx'
import Ropa from './pages/Ropa.jsx'
import Hogar from './pages/Hogar.jsx'
import Deportes from './pages/Deportes.jsx'
import Juguetes from './pages/Juguetes.jsx'


function App() {
  // const handleAgregar = (producto) => {
  //   console.log("Agregado:", producto);
  // };

  return (
    <>
    
    <ThemeProvider>
      <div className="App">
        <Navbar />
        <div className="content">
          <Routes>
            <Route path="/electronica" element={<Electronica />} />
            <Route path="/ropa" element={<Ropa />} />
            <Route path="/hogar" element={<Hogar />} />
            <Route path="/deportes" element={<Deportes />} />
            <Route path="/juguetes" element={<Juguetes />} />
            <Route path="/nosotros" element={<Nosotros />} />
          </Routes>
        </div>
        <Footer />
      </div>
    </ThemeProvider>
      
    </>
  );
}

export default App;

