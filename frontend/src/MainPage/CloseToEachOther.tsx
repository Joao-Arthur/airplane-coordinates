import { useForm } from 'react-hook-form';
import { Button } from '../components/Button';
import { Form } from '../components/Form';
import { Input } from '../components/Input';
import { useAirplanes } from '../integrations/airplane/useAirplanes';

type fieldsType = {
    readonly maxDistance: number;
}

export function CloseToEachOther() {
    const { register, handleSubmit } = useForm<fieldsType>({
        defaultValues: {
            maxDistance: 0,
        },
    });
    const { getCloseToEachOther } = useAirplanes();

    function onHandleSubmit({ maxDistance }: fieldsType) {
        getCloseToEachOther({ maxDistance });
    }

    return (
        <Form name='Aviões próximos entre si' onSubmit={handleSubmit(onHandleSubmit)}>
            <Input {...register('maxDistance', { valueAsNumber: true, required: true })} title='Distancia mínima' />
            <Button>Calcular</Button>
        </Form>
    );
}
