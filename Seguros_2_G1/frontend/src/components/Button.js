const Button = ({ classes, children, size }) => (
  <button className={`btn ${classes}`}>{children}</button>
);

export default Button;
