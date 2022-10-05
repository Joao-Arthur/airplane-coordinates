import { useAirplaneStore } from '../../integrations/airplane/airplanesStore';

export function AirplanesTable() {
    const airplanes = useAirplaneStore(state => state.airplanes);
    const selectedAirplanes = useAirplaneStore(state => state.selectedAirplanes);
    const selectAirplane = useAirplaneStore(state => state.selectAirplane);
    const unselectAirplane = useAirplaneStore(state => state.unselectAirplane);

    return (
        <div className='overflow-x-auto h-1/2 w-full'>
            <table className='text-sm divide-y-2 divide-gray-200 w-full'>
                <thead>
                    <tr>
                        <td className='invisible'>Seleção</td>
                        <th style={{ width: '14.28%' }} className='px-4 py-2 font-medium text-left text-gray-900 whitespace-nowrap'>Id</th>
                        <th style={{ width: '14.28%' }} className='px-4 py-2 font-medium text-left text-gray-900 whitespace-nowrap'>X</th>
                        <th style={{ width: '14.28%' }} className='px-4 py-2 font-medium text-left text-gray-900 whitespace-nowrap'>Y</th>
                        <th style={{ width: '14.28%' }} className='px-4 py-2 font-medium text-left text-gray-900 whitespace-nowrap'>R</th>
                        <th style={{ width: '14.28%' }} className='px-4 py-2 font-medium text-left text-gray-900 whitespace-nowrap'>A</th>
                        <th style={{ width: '14.28%' }} className='px-4 py-2 font-medium text-left text-gray-900 whitespace-nowrap'>V</th>
                        <th style={{ width: '14.28%' }} className='px-4 py-2 font-medium text-left text-gray-900 whitespace-nowrap'>D</th>
                    </tr>
                </thead>
                <tbody className='divide-y divide-gray-200'>
                    {airplanes.map(airplane => (
                        <tr key={airplane.id}>
                            <td className='px-4 py-2 text-gray-700 whitespace-nowrap'>
                                <input
                                    type='checkbox'
                                    checked={selectedAirplanes.includes(airplane.id)}
                                    onChange={e => {
                                        if (e.target.checked)
                                            selectAirplane(airplane.id);
                                        else
                                            unselectAirplane(airplane.id);

                                    }}
                                />
                            </td>
                            <td style={{ width: '14.28%' }} className='px-4 py-2 font-medium text-gray-900 whitespace-nowrap'>{airplane.id}</td>
                            <td style={{ width: '14.28%' }} className='px-4 py-2 text-gray-700 whitespace-nowrap'>{airplane.x}</td>
                            <td style={{ width: '14.28%' }} className='px-4 py-2 text-gray-700 whitespace-nowrap'>{airplane.y}</td>
                            <td style={{ width: '14.28%' }} className='px-4 py-2 text-gray-700 whitespace-nowrap'>{airplane.radius}</td>
                            <td style={{ width: '14.28%' }} className='px-4 py-2 text-gray-700 whitespace-nowrap'>{airplane.angle}</td>
                            <td style={{ width: '14.28%' }} className='px-4 py-2 text-gray-700 whitespace-nowrap'>{airplane.speed}</td>
                            <td style={{ width: '14.28%' }} className='px-4 py-2 text-gray-700 whitespace-nowrap'>{airplane.direction}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div >
    );
}
