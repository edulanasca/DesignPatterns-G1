import { Switch, Route } from "react-router-dom";

import Navbar from "./components/Navbar";
import Home from "./components/Home";
import Usuarios from "./components/Usuarios";
import CreateUser from "./components/CreateUser";

function App() {
  return (
    <>
      <Navbar />

      <div className="container mt-3">
        <Switch>
          <Route path="/users" component={Usuarios} />
          <Route path="/create-user" component={CreateUser} />
          <Route path="/" exact component={Home} />
        </Switch>
      </div>
    </>
  );
}

export default App;
