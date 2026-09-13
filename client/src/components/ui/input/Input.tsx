import styles from '../input/Input.module.css';

function Input({ type, placeholder, value, onChange }) {
    return (
        <input
            className={styles.input}
            type={type}
            placeholder={placeholder}
            value={value}
            onChange={onChange}
        />
    );
}

export default Input;