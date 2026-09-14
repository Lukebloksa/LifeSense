import styles from '../input/Input.module.css';

function Input({label, type, placeholder, value, onChange }) {
    return (
        <div className={styles.inputContainer}>
            <label className={styles.label}>{label}</label>
            <input
                className={styles.input}
                type={type}
                placeholder={placeholder}
                value={value}
                onChange={onChange}
            />
        </div>
    );
}

export default Input;