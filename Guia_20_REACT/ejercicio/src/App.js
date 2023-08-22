
import './App.css';
import NavBar from './components/public/NavBar';
import Main from './components/public/Main';
import { SecondMain } from './components/public/SecondMain';
import { Footer } from './components/public/Footer';
import { Routes, Route } from "react-router-dom";
import UserForm from './components/public/UserForm';
import UserLogin from './components/public/UserLogin';
import Detail from './components/public/Detail';



function App() {
  return (
    <div className="App">

      <NavBar />

      <Routes>
        <Route exact path={"/"} element={<Main />} />
        <Route exact path={"/main2"} element={<SecondMain />} />
        <Route path={"/user-login"} element={<UserLogin />} />
        <Route path={"/user-form"} element={<UserForm />} />
        <Route path={"/detail/:id"} element={<Detail />} />

      </Routes>

      <Footer />

    </div>
  );
}

export default App;
