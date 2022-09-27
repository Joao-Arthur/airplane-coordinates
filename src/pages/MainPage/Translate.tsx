import { useState } from 'react';
import { Button } from '../../components/Button';
import { Input } from '../../components/Input';

type props = {
    selectedIds: readonly string[];
    translateCoordinates: (
        selectedIds: readonly string[],
        x: number,
        y: number,
    ) => void;
}

export function Translate({ selectedIds, translateCoordinates }: props) {
    const [x, setX] = useState(0);
    const [y, setY] = useState(0);

    function onClick() {
        translateCoordinates(selectedIds, x, y);
    }

    return (
        <>
            <Input title='X' name='x' value={x} onChange={setX} />
            <Input title='Y' name='y' value={y} onChange={setY} />
            <Button title='Transladar' onClick={onClick} />
        </>
    );
}