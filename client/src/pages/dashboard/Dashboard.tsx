import { useState } from "react";

import styles from "./Dashboard.module.css"

import SensorCard from "../../components/sensorCard/SensorCard"
import SensorGraph, {DataPoint} from "../../components/sensorGraph/SensorGraph"

export interface SensorData {
    id: string | number;
    title: string;
    value: number;
    unit: string;
    timestamp?: String;
    isDark?: boolean;
}

const initialSensors: SensorData[] = [
    { id: 1, title: 'Temperature', value: 24.5, unit: '°C', isDark: false },
    { id: 2, title: 'Humidity', value: 45, unit: '%', isDark: false },
    { id: 3, title: 'CO₂', value: 620, unit: 'ppm', isDark: false },
];

const mockSensorData: SensorData[] = [
    { id: 1, title: 'Temperature', value: 24.5, unit: '°C', timestamp: '12:00', isDark: false },
    { id: 2, title: 'Humidity', value: 45, unit: '%', timestamp: '13:00', isDark: false },
    { id: 3, title: 'CO₂', value: 620, unit: 'ppm', timestamp: '14:00', isDark: false },
];

export default function Dashboard() {

    const [history, setHistory] = useState<DataPoint[]>([
        { timestamp: '12:00', value: 21 },
        { timestamp: '13:00', value: 23 },
        { timestamp: '14:00', value: 25 },
        { timestamp: '15:00', value: 22 },
    ]);

    // Přidání nového měření na konec
    const addMeasurement = (time: string, val: number) => {
        setHistory((prev) => [...prev, { timestamp: time, value: val }]);
    };

    // Smazání nejstaršího (prvního) měření
    const removeOldest = () => {
        setHistory((prev) => prev.slice(1));
    };

    // Smazání nejnovějšího (posledního) měření
    const removeNewest = () => {
        setHistory((prev) => prev.slice(0, -1));
    };

    // Typický IoT scénář: držet max 10 posledních hodnot (nové přidat, nejstarší zahodit)
    const pushNewAndKeepMax = (time: string, val: number) => {
        setHistory((prev) => {
            const updated = [...prev, { timestamp: time, value: val }];
            return updated.length > 10 ? updated.slice(1) : updated;
        });
    };
    return (
        <div className={styles.dashboardContainer}>
            <div className={styles.dashboardNavbar}>

            </div>
            <div className={styles.sensorCardContainer}>
                {initialSensors.map((sensor) => (
                    <SensorCard
                        key={sensor.id}
                        title={sensor.title}
                        unit={sensor.unit}
                        value={sensor.value}
                        isDark={sensor.isDark}
                    />
                ))}
            </div>
            <div className={styles.sensorGraphContainer}>
                {mockSensorData.map((sensor) => (
                    <SensorGraph
                        key={sensor.id}
                        data={history}
                        unit={sensor.unit}
                        title={sensor.title}
                    />
                ))}
            </div>
        </div>
    )
}