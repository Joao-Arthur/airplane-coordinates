import { useState } from 'react';
import { Button } from '../../components/Button';
import { Input } from '../../components/Input';

type props = {
    translateCoordinates: (
        selectedIds: readonly string[],
        x: number,
        y: number,
    ) => void;
}

export function Translate({ translateCoordinates }: props) {
    const [x, setX] = useState(0);
    const [y, setY] = useState(0);

    function onClick() {

    }

    return (
        <>
            <Input title='X' name='x' value={x} onChange={setX} />
            <Input title='Y' name='y' value={y} onChange={setY} />
            <Button title='Transladar' onClick={onClick} />
        </>
    );
}