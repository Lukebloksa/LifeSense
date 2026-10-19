import { useState } from "react";

import styles from "./Dashboard.module.css"

import SensorCard from "../../components/sensorCard/SensorCard"
import SensorGraph, {DataPoint} from "../../components/sensorGraph/SensorGraph"
import Navigation from "../../components/navigation/Navigation"

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
        { timestamp: '00:00', value: 19.8 },
        { timestamp: '01:00', value: 19.4 },
        { timestamp: '02:00', value: 19.1 },
        { timestamp: '03:00', value: 18.9 },
        { timestamp: '04:00', value: 18.7 },
        { timestamp: '05:00', value: 18.8 },
        { timestamp: '06:00', value: 19.2 },
        { timestamp: '07:00', value: 20.1 },
        { timestamp: '08:00', value: 21.3 },
        { timestamp: '09:00', value: 22.4 },
        { timestamp: '10:00', value: 23.2 },
        { timestamp: '11:00', value: 23.8 },
        { timestamp: '12:00', value: 24.1 },
        { timestamp: '13:00', value: 24.6 },
        { timestamp: '14:00', value: 25.2 },
        { timestamp: '15:00', value: 25.5 },
        { timestamp: '16:00', value: 25.1 },
        { timestamp: '17:00', value: 24.6 },
        { timestamp: '18:00', value: 23.8 },
        { timestamp: '19:00', value: 22.9 },
        { timestamp: '20:00', value: 22.1 },
        { timestamp: '21:00', value: 21.4 },
        { timestamp: '22:00', value: 20.7 },
        { timestamp: '23:00', value: 20.2 },
    ]);

    const addMeasurement = (time: string, val: number) => {
        setHistory((prev) => [...prev, { timestamp: time, value: val }]);
    };

    const removeOldest = () => {
        setHistory((prev) => prev.slice(1));
    };

    const removeNewest = () => {
        setHistory((prev) => prev.slice(0, -1));
    };

    const pushNewAndKeepMax = (time: string, val: number) => {
        setHistory((prev) => {
            const updated = [...prev, { timestamp: time, value: val }];
            return updated.length > 10 ? updated.slice(1) : updated;
        });
    };
    return (
        <div className={styles.dashboardContainer}>
            <div className={styles.dashboardNavbar}>
                <Navigation />
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