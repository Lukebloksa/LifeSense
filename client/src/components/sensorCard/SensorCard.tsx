import styles from './SensorCard.module.css'

interface SensorCardProps {
    title: string;
    value: number;
    unit: string;
    isDark?: boolean;
}

function SensorCard({title, value, unit, isDark} : SensorCardProps) {
    return (
        <div className={styles.sensorCard}>
            <div className="sensor-card-information">
                <span className="sensor-card-header" aria-placeholder="Sensor Card Information">
                    {title}
                </span>
                <div className="sensor-card-description">
                    <span className="sensor-card-value" aria-placeholder="Description">
                        {value}
                    </span>
                    <span className="sensor-card-difference" aria-placeholder="Description">
                        {unit}
                    </span>
                </div>
            </div>
        </div>
    )
}

export default SensorCard;