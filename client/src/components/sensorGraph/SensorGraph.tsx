import {
    LineChart,
    Line,
    XAxis,
    YAxis,
    Tooltip,
    ResponsiveContainer,
    CartesianGrid,
} from 'recharts';

import styles from './SensorGraph.module.css';

export interface DataPoint {
    timestamp: string;
    value: number;
}

type SensorGraphProps = {
    data: DataPoint[]; // Pole naměřených hodnot v čase
    unit: string;
    title: string;
};

function SensorGraph({ data, unit, title }: SensorGraphProps) {
    return (
        <div className={styles.graphConteiner}>
            <div className={styles.graphHeader}>
                <span className={styles.graphTitle}>{title}</span>
            </div>

            <ResponsiveContainer className={styles.sensorGraphContainer} width="100%" height="100%">
                <LineChart data={data}>
                    <CartesianGrid stroke="#000000" strokeDasharray="3 3" opacity={0.1} />
                    <XAxis dataKey="timestamp" stroke="#000000" />
                    <YAxis stroke="#000000" unit={unit} />
                    <Tooltip />
                    <Line
                        type="monotone"
                        dataKey="value"
                        stroke="#31AE4D"
                        strokeWidth={2}
                        dot={{ r: 3, fill: '#31AE4D' }}
                    />
                </LineChart>
            </ResponsiveContainer>
        </div>
    );
}

export default SensorGraph;