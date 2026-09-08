// Source - https://stackoverflow.com/q/67432014
// Posted by Chris K.
// Retrieved 2026-09-08, License - CC BY-SA 4.0

import Chartjs from 'chart.js';

function SensorGraph({ data, labels }: { data: number[]; labels: string[] }) {
    return (
        <canvas id="sensorGraph" aria-label="Sensor Graph" role="img"></canvas>
    )
}