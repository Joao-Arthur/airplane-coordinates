import { Button } from "../../components/Button";
import { Input } from "../../components/Input";

type props = {
    translateCoordinates: (
        selectedIds: readonly string[],
        x: number,
        y: number,
    ) => void;
}

export function Translate({ translateCoordinates }: props) {
    return (
        <>
            <Input title='X' name='x' />
            <Input title='Y' name='y' />
            <Button title='Transladar' onClick={() => { }} />
        </>
    );
}