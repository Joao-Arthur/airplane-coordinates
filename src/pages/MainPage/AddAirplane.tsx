import { useForm } from 'react-hook-form';
import { Button } from '../../components/Button';
import { Form } from '../../components/Form';
import { Group } from '../../components/Group';
import { Input } from '../../components/Input';
import { Select } from '../../components/Select';
import { useAirplanes } from '../../integrations/airplane/useAirplanes';

type fieldsType = {
    readonly x: number;
    readonly y: number;
    readonly radius: number;
    readonly angle: number;
    readonly speed: number;
    readonly direction: number;
    readonly coordinatesType: 'cartesian' | 'polar';
}

export function AddAirplane() {
    const { register, handleSubmit, watch } = useForm<fieldsType>({
        defaultValues: {
            x: 0,
            y: 0,
            radius: 0,
            angle: 0,
            speed: 0,
            direction: 0,
            coordinatesType: 'cartesian',
        },
    });

    const { add } = useAirplanes();

    function onHandleSubmit({ speed, direction, coordinatesType, x, y, radius, angle }: fieldsType) {
        add({
            airplaneParams: {
                speed,
                direction,
                ...(coordinatesType === 'cartesian' ? {
                    x,
                    y,
                } : {
                    radius,
                    angle,
                }),
            },
        });
    }

    return (
        <Form name='Adicionar' onSubmit={handleSubmit(onHandleSubmit)}>
            <Select
                {...register('coordinatesType')}
                title='Coordenadas'
                options={[
                    { name: 'polar', label: 'Polares' },
                    { name: 'cartesian', label: 'Cartesianas' },
                ]}
            />
            <Group>
                {watch('coordinatesType') === 'cartesian' ? (
                    <>
                        <Input {...register('x', { valueAsNumber: true, required: true })} title='X' key='x' />
                        <Input  {...register('y', { valueAsNumber: true, required: true })} title='Y' key='y' />
                    </>
                ) : (
                    <>
                        <Input {...register('radius', { valueAsNumber: true, required: true })} title='Raio' key='radius' />
                        <Input {...register('angle', { valueAsNumber: true, required: true })} title='Ângulo' key='angle' />
                    </>
                )}
                <Input {...register('speed', { valueAsNumber: true, required: true })} title='Velocidade' />
                <Input {...register('direction', { valueAsNumber: true, required: true })} title='Direção' />
            </Group>
            <Button title='Adicionar' />
        </Form>
    );
}
