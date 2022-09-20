import { Button } from "../../components/Button";
import { Input } from "../../components/Input";

export function CloseToEachOther() {
    return (
        <>
            <Input title='Distancia mínima' name='minDistance' />
            <Button title='Aviões próximos entre si' onClick={() => { }} />
        </>
    );
}