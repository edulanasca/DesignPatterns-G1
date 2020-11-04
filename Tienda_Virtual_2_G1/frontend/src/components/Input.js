const Input = ({ labelName, value, changed }) => {
  return (
    <div className="form-group">
      <label htmlFor={labelName}>{labelName}:</label>
      <input
        type="text"
        className="form-control"
        id={labelName}
				value={value}
				onChange={changed}
      />
    </div>
  );
};

export default Input;
