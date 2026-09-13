export function useAuth() {
    const login = async (email: string, password: string) => {
        const res = await fetch('http://localhost:5000/api/auth/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ email, password }),
        });

        if (!res.ok) {
            throw new Error('Invalid email or password');
        }

        const data = await res.json();

        localStorage.setItem('token', data.token);
    };

    const logout = () => {
        localStorage.removeItem('token');
    };

    const register = async (username: string, email: string, password: string) => {
        const res = await fetch('http://localhost:5000/api/auth/register', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ username, email, password }),
        });

        if (!res.ok) {
            throw new Error('Registration failed');
        }

        const data = await res.json();

        localStorage.setItem('token', data.token);
    }

    return { login, logout, register };
}