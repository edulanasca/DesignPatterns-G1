import { useState, useEffect } from "react";

import Spinner from "./Spinner/Spinner";

const Usuarios = () => {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    setTimeout(() => {
      fetch("http://localhost:7000/api/customers")
      .then((response) => response.json())
      .then(data => setUsers(data));
    }, 1000);
  }, []);

  const usersList = users.map((user) => (
    <tr key={user.nombre}>
      <th scope="row">{user.nombre}</th>
      <td>{user.direccion}</td>
      <td>{user.numeroDocumento}</td>
    </tr>
  ));

  const content = users.length ? (
    <table className="table">
      <thead>
        <tr>
          <th scope="col">Nombre</th>
          <th scope="col">Dirección</th>
          <th scope="col">Número de documento</th>
        </tr>
      </thead>
      <tbody>{usersList}</tbody>
    </table>
  ) : (
    <Spinner />
  );

  return <section>{content}</section>;
};

export default Usuarios;
