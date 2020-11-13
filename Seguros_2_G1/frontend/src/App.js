import { useState } from "react";

import Button from "./components/Button";
import Input from "./components/Input";

const App = () => {
  const formStyle = {
    width: "500px",
  };

  const [mainInputs, setMainInputs] = useState({
    nombre: { value: "", placeholder: "Nombre completo", inputType: "input" },
    nuermoPoliza: {
      value: "",
      placeholder: "Número de póliza",
      inputType: "input",
    },
    tipoPoliza: {
      inputType: "select",
      options: [
        { value: "", displayValue: "-- Selecciona un tipo de póliza --" },
        { value: "vehicular", displayValue: "Vehicular" },
        { value: "tarjeta", displayValue: "Tarjeta" },
      ],
      value: "",
    },
  });

  const [vehicularInputs, setVehicularInputs] = useState({
    vehiculo: {
      inputType: "select",
      options: [
        { value: "toyota", displayValue: "Toyota" },
        { value: "yaris", displayValue: "Yaris" },
      ],
      value: "",
    },
    tipoSeguro: {
      inputType: "select",
      options: [
        { value: "choque", displayValue: "Choque" },
        { value: "robo", displayValue: "Robo" },
        { value: "soat", displayValue: "SOAT" },
        { value: "todoRiesgo", displayValue: "Todo Riesgo" },
      ],
      value: "",
    },
  });

  const [tarjetaInputs, setTarjetaInputs] = useState({
    bancoProcedencia: {
      inputType: "select",
      options: [
        { value: "azteca", displayValue: "Azteca" },
        { value: "bcp", displayValue: "BCP" },
        { value: "interbank", displayValue: "Interbank" },
      ],
    },
  });

  const [showVehiculos, setShowVehiculos] = useState(false);
  const [showTarjetas, setShowTarjetas] = useState(false);

  const changedMainValueHandler = (e, id) => {
    const updatedMainInputs = { ...mainInputs };
    const updatedFormElement = { ...updatedMainInputs[id] };

    updatedFormElement.value = e.target.value;
    updatedMainInputs[id] = updatedFormElement;

    setMainInputs(updatedMainInputs);
  };

  const changedVehicularValueHandler = (e, id) => {
    const updatedVehicularInputs = { ...vehicularInputs };
    const updatedFormElement = { ...updatedVehicularInputs[id] };

    updatedFormElement.value = e.target.value;
    updatedVehicularInputs[id] = updatedFormElement;

    setVehicularInputs(updatedVehicularInputs);
  };

  const changedTarjetaValueHandler = (e, id) => {
    const updatedTarjetaInputs = { ...tarjetaInputs };
    const updatedFormElement = { ...updatedTarjetaInputs[id] };

    updatedFormElement.value = e.target.value;
    updatedTarjetaInputs[id] = updatedFormElement;

    setTarjetaInputs(updatedTarjetaInputs);
  };

  const mainInputsInfo = [];

  for (const key in mainInputs) {
    mainInputsInfo.push({ id: key, data: mainInputs[key] });
  }

  const mainInputsForm = mainInputsInfo.map(({ id, data }) => (
    <Input
      key={id}
      id={id}
      inputType={data.inputType}
      value={data.value}
      placeholder={data.placeholder}
      options={data.options}
      changed={changedMainValueHandler}
    />
  ));

  const vehicularInputsInfo = [];

  for (const key in vehicularInputs) {
    vehicularInputsInfo.push({ id: key, data: vehicularInputs[key] });
  }

  const vehicularInputsForm = vehicularInputsInfo.map(({ id, data }) => (
    <Input
      key={id}
      id={id}
      inputType={data.inputType}
      value={data.value}
      options={data.options}
      changed={changedVehicularValueHandler}
    />
  ));

  const tarjetaInputsInfo = [];

  for (const key in tarjetaInputs) {
    tarjetaInputsInfo.push({ id: key, data: tarjetaInputs[key] });
  }

  const tarjetaInputsForm = tarjetaInputsInfo.map(({ id, data }) => (
    <Input
      key={id}
      id={id}
      inputType={data.inputType}
      value={data.value}
      options={data.options}
      changed={changedTarjetaValueHandler}
    />
  ));

  const [inputValues, setInputValues] = useState({
    nombre: "",
    numeroPoliza: ""
  })

  const changes = (e) => {
    const target = e.target;
    const value = target.value;

    
  }

  return (
    <div className="container">
      <div className="text-center mt-5">
        <Button classes="btn-primary">Registrar Usuario</Button>
      </div>

      <form action="#" className="border mt-5 p-4 mx-auto" style={formStyle}>
        <p className="h4">Datos personales</p>

        <input 
          name="nombre"
          type="text"
          onChange={}
        />

        <Input
          id={}
          inputType={data.inputType}
          value={data.value}
          options={data.options}
          changed={changedTarjetaValueHandler}
        />

        {mainInputsForm}

        {vehicularInputsForm}

        {tarjetaInputsForm}

        <Button classes="btn-success btn-block">Registrar</Button>
      </form>
    </div>
  );
};

export default App;
