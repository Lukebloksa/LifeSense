import {useState} from 'react'

import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom'

import './App.css'
import Dashboard from "./pages/dashboard/Dashboard";
import LoginPage from './pages/auth/login/LoginPage'
// import Dasboard from './pages/auth/register/RegisterPage'

function App() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Navigate to="/dashboard" replace />} />

                <Route path="/login" element={<LoginPage />} />

                <Route path="/dashboard" element={<Dashboard />} />
            </Routes>
        </BrowserRouter>
    )
}

export default App
