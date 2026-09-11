import {
    LineChart,
    Line,
    XAxis,
    YAxis,
    Tooltip,
    ResponsiveContainer,
    CartesianGrid
} from 'recharts';

const mockData = [
    { time: '12:00', temp: 21.5 },
    { time: '13:00', temp: 22.1 },
    { time: '14:00', temp: 24.8 },
    { time: '15:00', temp: 23.4 },
    { time: '16:00', temp: 22.0 },
];

import styles from "./SensorGraph.module.css";

function SensorGraph({ data }: { data;}) {
    return (
        <div className={styles.graphConteiner}>
            <div className={styles.graphHeader}>
                <span className={styles.graphTitle}>Temperature</span>
            </div>
            <ResponsiveContainer className={styles.sensorGraphContainer} width="100%" height="100%">
                <LineChart data={mockData} >
                    <CartesianGrid stroke="#000000" strokeDasharray="3 3" opacity={0.4} />

                    <XAxis dataKey="time" stroke="#000000" />
                    <YAxis stroke="#000000" unit="°C" />

                    <Tooltip />

                    <Line
                        type="monotone"
                        dataKey="temp"
                        stroke="#31AE4D"
                        strokeWidth={2}
                        dot={{ r: 2, fill: '#31AE4D' }}
                    />
                </LineChart>
            </ResponsiveContainer>
        </div>
     )
}

export default SensorGraph;