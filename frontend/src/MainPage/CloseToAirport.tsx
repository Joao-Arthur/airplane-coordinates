import { useForm } from 'react-hook-form';
import { Button } from '../components/Button';
import { Form } from '../components/Form';
import { Input } from '../components/Input';
import { useAirplanes } from '../integrations/airplane/useAirplanes';

type fieldsType = {
    readonly maxDistance: string;
}

export function CloseToAirport() {
    const { register, handleSubmit } = useForm<fieldsType>({
        defaultValues: {
            maxDistance: '0',
        },
    });
    const { getCloseToAirport } = useAirplanes();

    function onHandleSubmit({ maxDistance }: fieldsType) {
        getCloseToAirport({ maxDistance });
    }

    return (
        <Form name='Aviões próximos ao aeroporto' onSubmit={handleSubmit(onHandleSubmit)}>
            <Input {...register('maxDistance', { min: '0', required: true })} title='Distancia mínima' />
            <Button>Calcular</Button>
        </Form>
    );
}
