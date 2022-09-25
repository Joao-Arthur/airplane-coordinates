import { Button } from "../../components/Button";
import { Input } from "../../components/Input";

type props = {
    getCloseToEachOther: (maxDistance: number) => void;
}

export function CloseToEachOther({ getCloseToEachOther }: props) {
    return (
        <>
            <Input title='Distancia mínima' name='minDistance' />
            <Button title='Aviões próximos entre si' onClick={() => { }} />
        </>
    );
}