
import './App.css';
import { Routes, Route } from "react-router-dom";
import Footer from './components/public/Footer';
import Main from './components/public/Main';
import NavBar from './components/public/NavBar';
import UserForm from './components/public/UserForm';
import Detail from './components/public/Detail';

function App() {
  return (
    <div>
      {/* Funtional component, los usamos para poder ahorrar espacio en la App.js y lo importamos de esta manera */}
      <NavBar />

      {/* El Routes va alterar la ruta a la que se va a ir */}
      <Routes>
        <Route exact path={"/"} element={<Main />} />
        <Route path={"/details/:id"} element={<Detail />} />
        <Route path={"/user-form"} element={<UserForm />} />
      </Routes>

      {/* Funtional component, los usamos para poder ahorrar espacio en la App.js y lo importamos de esta manera */}
      <Footer />

    </div>
  );
}

export default App;
