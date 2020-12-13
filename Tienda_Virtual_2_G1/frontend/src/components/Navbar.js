import { NavLink, Link } from 'react-router-dom';

const Navbar = () => (
	<nav className='navbar navbar-expand-lg navbar-light bg-light'>
		<div className='container'>
			<Link to='/' className='navbar-brand'>
				Tienda Virtual
			</Link>
			<div className='navbar-nav mr-auto'>
				<NavLink to='/users' className='nav-link'>
					Lista Usuarios
				</NavLink>
				<NavLink to='/create-user' className='nav-link'>
					Registrar Usuario
				</NavLink>
				<NavLink to='/create-product' className='nav-link'>
					Registrar Producto
				</NavLink>
			</div>
		</div>
	</nav>
);

export default Navbar;
