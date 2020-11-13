const Input = (props) => {
  let inputElement;

  switch (props.inputType) {
    case "input":
      inputElement = (
        <input
          type="text"
          className="form-control mb-4"
          placeholder={props.placeholder}
          value={props.value}
          onChange={(e) => props.changed(e, props.id)}
        />
      );
      break;
    case "select":
      inputElement = (
        <select
          className="form-control mb-4"
          value={props.value}
          onChange={(e) => props.changed(e, props.id)}
        >
          {props.options.map(({ value, displayValue }) => (
            <option key={value} value={value}>
              {displayValue}
            </option>
          ))}
        </select>
      );
      break;
    default:
      break;
  }

  return <>{inputElement}</>;
};

export default Input;
