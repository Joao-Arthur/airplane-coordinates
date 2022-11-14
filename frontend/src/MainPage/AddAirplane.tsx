import { useForm } from 'react-hook-form';
import { Button } from '../components/Button';
import { Form } from '../components/Form';
import { Group } from '../components/Group';
import { Input } from '../components/Input';
import { Select } from '../components/Select';
import { useAirplanes } from '../integrations/airplane/useAirplanes';

type fieldsType = {
    readonly coordinatesType: 'CARTESIAN' | 'POLAR';
    readonly x: string;
    readonly y: string;
    readonly r: string;
    readonly a: string;
    readonly speed: string;
    readonly direction: string;
}

export function AddAirplane() {
    const { add } = useAirplanes();
    const { register, handleSubmit, watch } = useForm<fieldsType>({
        defaultValues: {
            coordinatesType: 'CARTESIAN',
            x: '0',
            y: '0',
            r: '0',
            a: '0',
            speed: '0',
            direction: '0',
        },
    });

    function onHandleSubmit({ speed, direction, x, y, r, a, coordinatesType }: fieldsType) {
        add({
            airplaneParams: {
                planePoint: coordinatesType === 'CARTESIAN' ? {
                    planeType: coordinatesType,
                    a: x,
                    b: y,
                } : {
                    planeType: coordinatesType,
                    a: r,
                    b: a,
                },
                vector: { speed, direction },
            },
        });
    }

    return (
        <Form name='Adicionar' onSubmit={handleSubmit(onHandleSubmit)}>
            <Select
                {...register('coordinatesType')}
                title='Coordenadas'
                options={[
                    { name: 'POLAR', label: 'Polares' },
                    { name: 'CARTESIAN', label: 'Cartesianas' },
                ]}
            />
            <Group>
                {watch('coordinatesType') === 'CARTESIAN' ? (
                    <>
                        <Input {...register('x', { required: true })} title='X' key='x' />
                        <Input  {...register('y', { required: true })} title='Y' key='y' />
                    </>
                ) : (
                    <>
                        <Input {...register('r', { required: true })} title='Raio' key='r' />
                        <Input {...register('a', { required: true })} title='Ângulo' key='a' />
                    </>
                )}
                <Input {...register('speed', { valueAsNumber: true, required: true })} title='Velocidade' />
                <Input {...register('direction', { valueAsNumber: true, required: true })} title='Direção' />
            </Group>
            <Button>Adicionar</Button>
        </Form>
    );
}
