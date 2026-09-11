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
            <div className={styles.sensorCardInformation}>
                <span className="sensor-card-header" aria-placeholder="Sensor Card Information">
                    {title}
                </span>
                <div className={styles.sensorCardValueContainer}>
                    <div className={styles.sensorCardValueContainer}>
                        <strong className={styles.sensorCardValue} aria-placeholder="Description">
                            {value}
                        </strong>
                        <strong className={styles.sensorCardUnit} aria-placeholder="Description">
                            {unit}
                        </strong>
                    </div>
                    <span className={styles.sensorCardDifference} aria-placeholder="Description">
                        {unit}
                    </span>
                </div>
            </div>
        </div>
    )
}

export default SensorCard;