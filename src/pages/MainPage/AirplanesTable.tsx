import { airplaneType } from '../../models/airplane';

export function AirplanesTable() {

    const airplanes: airplaneType[] = [
        { id: '1', x: 10, y: 20, speed: 1000, direction: 100 },
        { id: '2', x: 1, y: -8, speed: 1000, direction: 100 },
        { id: '3', x: -9, y: -1, speed: 1000, direction: 100 },
        { id: '4', x: -3, y: 5, speed: 1000, direction: 100 },
    ];

    return (
        <div className='overflow-x-auto'>
            <table className='min-w-full text-sm divide-y-2 divide-gray-200'>
                <thead>
                    <tr>
                        <td className='invisible'>Seleção</td>
                        <th className='px-4 py-2 font-medium text-left text-gray-900 whitespace-nowrap'>Id</th>
                        <th className='px-4 py-2 font-medium text-left text-gray-900 whitespace-nowrap'>X</th>
                        <th className='px-4 py-2 font-medium text-left text-gray-900 whitespace-nowrap'>Y</th>
                        <th className='px-4 py-2 font-medium text-left text-gray-900 whitespace-nowrap'>Speed</th>
                        <th className='px-4 py-2 font-medium text-left text-gray-900 whitespace-nowrap'>Direction</th>
                    </tr>
                </thead>
                <tbody className='divide-y divide-gray-200'>
                    {airplanes.map(airplane => (
                        <tr key={airplane.id}>
                            <td className='px-4 py-2 text-gray-700 whitespace-nowrap'>
                                <input type='checkbox' />
                            </td>
                            <td className='px-4 py-2 font-medium text-gray-900 whitespace-nowrap'>{airplane.id}</td>
                            <td className='px-4 py-2 text-gray-700 whitespace-nowrap'>{airplane.x}</td>
                            <td className='px-4 py-2 text-gray-700 whitespace-nowrap'>{airplane.y}</td>
                            <td className='px-4 py-2 text-gray-700 whitespace-nowrap'>{airplane.speed}</td>
                            <td className='px-4 py-2 text-gray-700 whitespace-nowrap'>{airplane.direction}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div >
    );
}