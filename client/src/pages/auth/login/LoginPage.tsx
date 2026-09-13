import Button from "../../../components/ui/button/Button";
import Input from "../../../components/ui/input/Input";
import styles from "./LoginPage.module.css";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../../../hooks/useAuth";

export function LoginPage() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();
    const { login } = useAuth();

    const handleLogin = async () => {
        try {
            await login(email, password);
            navigate("/dashboard");
        } catch (error) {
            console.error("Login failed:", error);
        }
    };

    return (
        <div className={styles.wrapper}>
            <div className={styles.card}>
                <h2 className={styles.title}>Log In</h2>
                <div className={styles.form}>
                    <Input
                        label="Email"
                        placeholder="Value"
                        type="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                    />
                    <Input
                        label="Password"
                        placeholder="Value"
                        type="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                    <div className={styles.actions}>
                        <Button onClick={handleLogin}>Sign In</Button>
                    </div>
                </div>
            </div>
        </div>
    )
}