import styles from "../button/Button.module.css"

function Button({ children, onClick }: { children: React.ReactNode; onClick?: () => void; }) {
    return (
        <button className={styles.button} onClick={onClick}>
            {children}
        </button>
    )
}
export default Button;