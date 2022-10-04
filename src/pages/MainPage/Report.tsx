import classNames from 'classnames';
import { nanoid } from 'nanoid';
import { useAirplaneStore } from '../../integrations/airplane/airplanesStore';

export function Report() {
    const reports = useAirplaneStore(state => state.reports);

    return (
        <div className='overflow-x-auto h-1/2'>
            <table className='min-w-full text-sm divide-y-2 divide-gray-200'>
                <tbody className='divide-y divide-gray-200'>
                    {reports.map(report => (
                        <tr key={nanoid()}>
                            <td className={
                                classNames('px-4 py-2 whitespace-nowrap',
                                    report.type === 'success' ? 'bg-green-50' : '',
                                    report.type === 'error' ? 'bg-red-50' : '',
                                    report.type === 'warn' ? 'bg-yellow-50' : '',
                                )
                            }>{report.content}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div >
    );
}
