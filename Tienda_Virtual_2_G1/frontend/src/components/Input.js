const Input = props => {
	const { inputType, labelName, value, options, changed, tipo } = props;
	let elemento;

	switch (inputType) {
		case 'input':
			elemento = (
				<input
					className='form-control'
					id={labelName}
					onChange={changed}
					type={tipo}
					value={value}
				/>
			);
			break;
		case 'select':
			elemento = (
				<select
					className='form-control'
					id={labelName}
					onChange={changed}
					value={value}
				>
					<option value='' disabled>
						Seleccione una opción
					</option>
					{options.map(({ value, displayValue }) => (
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

	return (
		<div className='form-group'>
			<label htmlFor={labelName}>{labelName}:</label>
			{elemento}
		</div>
	);
};

export default Input;
