import Button from "../../../components/ui/button/Button";
import Input from "../../../components/ui/input/Input";
import styles from "./RegisterPage.module.css";
import { useState } from "react";
import { useNavigate, Link } from "react-router-dom";
import { useAuth } from "../../../hooks/useAuth";

export function RegisterPage() {
    const [username, setUsername] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();
    const { register } = useAuth();

    const handleRegister = async () => {
        try {
            await register(username, email, password);
            navigate("/dashboard");
        } catch (error) {
            console.error("Registration failed:", error);
        }
    };

    return (
        <div className={styles.wrapper}>
            <div className={styles.card}>
                <h2 className={styles.title}>Register</h2>
                <div className={styles.form}>
                    <Input
                        label="Username"
                        placeholder="Enter your username"
                        type="text"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                    />
                    <Input
                        label="Email"
                        placeholder="Enter your email"
                        type="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                    />
                    <Input
                        label="Password"
                        placeholder="Enter your password"
                        type="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                    <div className={styles.actions}>
                        <Button onClick={handleRegister}>Register</Button>
                        <p className={styles.authPrompt}>
                            Already have an account?{' '}
                            <Link className={styles.link} to="/login">
                                Sign in here
                            </Link>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    )
}
export default RegisterPage;