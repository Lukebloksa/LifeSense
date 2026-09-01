import { useState } from "react";
import SensorCard from "../components/sensorCard/SensorCard"
// import SensorGraph  from "../components/sensorGraph/SensorGraph"

export default function Dashboard() {
    return (
        <SensorCard title={"Temperature"} unit={"°C"} value={25} isDark={false} />
    )
}