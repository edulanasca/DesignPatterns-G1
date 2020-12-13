import { useState } from 'react';

import Button from './Button';
import Input from './Input';
import Message from './Message/Message';

const CreateProduct = () => {
	const [inputs, setInputs] = useState({
		codigo: {
			value: '',
			labelName: 'Código',
			inputType: 'input',
			tipo: 'text'
		},
		descripcion: {
			value: '',
			labelName: 'Descripción',
			inputType: 'input',
			tipo: 'text'
		},
		precioBase: {
			value: '',
			labelName: 'Precio Base',
			inputType: 'input',
			tipo: 'number'
		},
		gama: {
			value: 'alta',
			options: [
				{ value: 'alta', displayValue: 'Alta' },
				{ value: 'media', displayValue: 'Media' },
				{ value: 'baja', displayValue: 'Baja' }
			],
			labelName: 'Gama',
			inputType: 'select'
		}
	});

	const [showMessage, setShowMessage] = useState(false);

	const changedValueHandler = (e, id) => {
		const updatedInputs = { ...inputs };
		const updatedElementForm = { ...updatedInputs[id] };

		updatedElementForm.value = e.target.value;
		updatedInputs[id] = updatedElementForm;

		setInputs(updatedInputs);
	};

	const handleSubmitForm = e => {
		e.preventDefault();

		const formData = {};

		for (let identifier in inputs) {
			formData[identifier] = inputs[identifier].value;
		}

		fetch('http://localhost:7000/api/products', {
			method: 'POST',
			body: JSON.stringify(formData)
		}).then(data => {
			if (data.status === 201) {
				setShowMessage(true);

				setInputs({
					...inputs, 
					codigo: {...inputs.codigo, value: ''}, 
					descripcion: {...inputs.descripcion, value: ''}, 
					precioBase: {...inputs.precioBase, value: ''}
				});


				setTimeout(() => {
					setShowMessage(false);
				}, 1500);
			}
		});
	};

	const inputsElements = [];

	for (let key in inputs) {
		inputsElements.push({
			id: key,
			data: inputs[key]
		});
	}

	const inputsForm = inputsElements.map(input => {
		if (input.data.options) {
			return (
				<Input
					changed={event => changedValueHandler(event, input.id)}
					key={input.id}
					inputType={input.data.inputType}
					labelName={input.data.labelName}
					options={input.data.options}
					value={input.data.value}
				/>
			);
		} else {
			return (
				<Input
					changed={event => changedValueHandler(event, input.id)}
					key={input.id}
					inputType={input.data.inputType}
					labelName={input.data.labelName}
					tipo={input.data.tipo}
					value={input.data.value}
				/>
			);
		}
	});

	const message = showMessage ? (
		<Message mensaje='Producto agregado correctamente' />
	) : null;

	return (
		<section className='row justify-content-center'>
			<form className='col-6' onSubmit={handleSubmitForm}>
				{message}
				{inputsForm}

				<Button classes='btn-primary btn-lg btn-block'>Agregar</Button>
			</form>
		</section>
	);
};

export default CreateProduct;
