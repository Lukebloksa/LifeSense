import { useState } from "react";

import styles from "./Dashboard.module.css"

import SensorCard from "../../components/sensorCard/SensorCard"
// import SensorGraph  from "../components/sensorGraph/SensorGraph"

export default function Dashboard() {
    return (
        <div className={styles.dashboardContainer}>
            <div className={styles.sensorCardContainer}>
                <SensorCard title={"Temperature"} unit={"°C"} value={25} isDark={false} />
                <SensorCard title={"Temperature"} unit={"°C"} value={25} isDark={false} />
                <SensorCard title={"Temperature"} unit={"°C"} value={25} isDark={false} />
                <SensorCard title={"Temperature"} unit={"°C"} value={25} isDark={false} />
            </div>
            <div className="sensorGraphContainer">

            </div>
        </div>
    )
}