import { useState } from 'react';
import { Button } from '../../components/Button';
import { Input } from '../../components/Input';
import { Select } from '../../components/Select';

type props = {
    add: (airplaneParams: { x: number; y: number; radius: number; angle: number; speed: number; direction: number; }) => void;
}

export function AddAirplane({ add }: props) {
    const [x, setX] = useState(0);
    const [y, setY] = useState(0);
    const [radius, setRadius] = useState(0);
    const [angle, setAngle] = useState(0);
    const [speed, setSpeed] = useState(0);
    const [direction, setDirection] = useState(0);
    const [coordinatesType, setCoordinatesType] = useState('cartesian');

    function onClick() {
        add({
            x,
            y,
            radius,
            angle,
            speed,
            direction,
        });
    }

    return (
        <>
            <Select
                title='Coordenadas'
                name='coordinates'
                options={[
                    { name: 'polar', label: 'Polares' },
                    { name: 'cartesian', label: 'Cartesianas' },
                ]}
                value={coordinatesType}
                onChange={setCoordinatesType}
            />
            {coordinatesType === 'cartesian' ? (
                <>
                    <Input title='X' name='x' value={x} onChange={setX} />
                    <Input title='Y' name='y' value={y} onChange={setY} />
                </>
            ) : (
                <>
                    <Input title='Raio' name='raio' value={radius} onChange={setRadius} />
                    <Input title='Ângulo' name='angulo' value={angle} onChange={setAngle} />
                </>
            )}
            <Input title='Velocidade' name='velocidade' value={speed} onChange={setSpeed} />
            <Input title='Direção' name='direcao' value={direction} onChange={setDirection} />
            <Button title='Adicionar' onClick={onClick} />
        </>
    );
}