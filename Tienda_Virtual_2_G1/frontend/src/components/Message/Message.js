import './Message';

const Message = ({ mensaje }) => (
	<div class='message alert alert-success' role='alert'>
		{mensaje}
	</div>
);

export default Message;
