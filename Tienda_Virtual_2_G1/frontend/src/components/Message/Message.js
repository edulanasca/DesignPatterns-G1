import './Message';

const Message = ({ mensaje }) => (
	<div className='message alert alert-success' role='alert'>
		{mensaje}
	</div>
);

export default Message;
