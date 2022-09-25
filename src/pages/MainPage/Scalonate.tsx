import { Button } from "../../components/Button";
import { Input } from "../../components/Input";

type props = {
    scalonateCoordinates: (
        selectedIds: readonly string[],
        x: number,
        y: number,
    ) => void;
}

export function Scalonate({ scalonateCoordinates }: props) {
    return (
        <>
            <Input title='X' name='x' />
            <Input title='Y' name='y' />
            <Button title='Escalonar' onClick={() => { }} />
        </>
    );
}