import { useState } from 'react';
import styles from './App.module.css';

const App = () => {
	const [showRegistroMessage, setShowRegistroMessage] = useState(false);

	const [showForm, setShowForm] = useState(false);

	const handleShowForm = () => {
		setShowForm(prevState => !prevState);
	};

	const [inputs, setInputs] = useState({
		seguro: 'robo',
		marca: '',
		modelo: '',
		afil: ''
	});

	const { seguro, marca, modelo, afil } = inputs;

	const handleInputChange = inputName => e => {
		setInputs({
			...inputs,
			[inputName]: e.target.value
		});
	};

	const [afiliados, setAfiliados] = useState([]);

	const handleAddAfiliado = e => {
		if (e.key === 'Enter' && afil !== '') {
			setAfiliados([...afiliados, e.target.value]);
			setInputs({ ...inputs, afil: '' });
		}
	};

	const handleRemoveAfiliado = nombre => {
		const afilidosUpdated = afiliados.filter(afiliado => afiliado !== nombre);
		setAfiliados(afilidosUpdated);
	};

	const handleSubmitForm = () => {
		if (marca && modelo && afiliados.length) {
			const data = {
				tipo: seguro,
				marca: marca,
				modelo: modelo,
				afiliados: afiliados
			};

			console.log(data);

			fetch('http://localhost:7000/seguros/', {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json'
				},
				body: JSON.stringify(data)
			})
				.then(res => res.json())
				.then(data => {
					console.log(data);

					setInputs({ seguro: 'robo', marca: '', modelo: '', afil: '' });

					setAfiliados([]);

					setShowRegistroMessage(true);

					setTimeout(() => {
						setShowRegistroMessage(false);
						setShowForm(false);
					}, 1500);
				})
				.catch(error => console.error(error));
		} else {
			alert('Los campos no pueden ir vacíos');
		}
	};

	return (
		<div className={['container pt-5', styles.app].join(' ')}>
			<div className={styles['button-container']}>
				<button className='btn btn-primary' onClick={handleShowForm}>
					Registrar Seguro
				</button>
			</div>

			{showForm ? (
				<div className={['mt-5 px-5 py-4', styles.form].join(' ')}>
					{showRegistroMessage ? (
						<div className='alert alert-success' role='alert'>
							Usuario registrado
						</div>
					) : null}
					<div className='form-group'>
						<label htmlFor='seguro'>Seguro</label>

						<select
							className='form-control'
							id='seguro'
							onChange={handleInputChange('seguro')}
							value={seguro}
						>
							<option value='robo'>Robo</option>
							<option value='soat'>SOAT</option>
							<option value='todoriesgo'>Todo Riesgo</option>
							<option value='empresa'>Empresa</option>
						</select>
					</div>

					<div className='form-group'>
						<label htmlFor='marca'>Marca</label>

						<input
							className='form-control'
							id='marca'
							onChange={handleInputChange('marca')}
							type='text'
							value={marca}
						/>
					</div>

					<div className='form-group'>
						<label htmlFor='modelo'>Modelo</label>

						<input
							className='form-control'
							id='modelo'
							onChange={handleInputChange('modelo')}
							type='text'
							value={modelo}
						/>
					</div>

					<div className='form-group'>
						<label htmlFor='afiliados'>Afiliados</label>

						<input
							className='form-control'
							id='afiliados'
							onChange={handleInputChange('afil')}
							onKeyPress={handleAddAfiliado}
							type='text'
							value={afil}
						/>
						<small className='form-text text-muted'>
							Presione enter para agregar un afiliado
						</small>

						{afiliados.length ? (
							<div className='mt-2'>
								<h6>Afiliados</h6>

								{afiliados.map((afiliado, i) => (
									<p key={i} className={['mb-1', styles.afiliado].join(' ')}>
										{afiliado}
										<i
											className='fas fa-times-circle'
											onClick={() => handleRemoveAfiliado(afiliado)}
										></i>
									</p>
								))}
							</div>
						) : null}
					</div>

					<div className={styles['button-container']}>
						<button className='btn btn-success' onClick={handleSubmitForm}>
							Registrarme
						</button>
					</div>
				</div>
			) : null}
		</div>
	);
};

export default App;
