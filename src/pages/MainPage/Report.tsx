import { nanoid } from 'nanoid'
import { messageType } from '../../features/logger/model';

type props = {
    reports: readonly messageType[];
}

export function Report({ reports }: props) {
    return (
        <div className='overflow-x-auto'>
            <table className='min-w-full text-sm divide-y-2 divide-gray-200'>
                <tbody className='divide-y divide-gray-200'>
                    {reports.map(report => (
                        <tr key={nanoid()}>
                            <td className='px-4 py-2 whitespace-nowrap'>{report.content}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div >
    );
}