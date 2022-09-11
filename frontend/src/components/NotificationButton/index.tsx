import axios from 'axios';
import { toast } from 'react-toastify';
import icon from '../../assets/img/notification-icon.svg'
import { BASE_URL } from '../../util/request';
import './styles.css'


type Props = {
    salesId:number;
}

function handleClick(id:number)
{
    axios (`${BASE_URL}/sales/${id}/notification`)
    .then(response =>{
        toast.info("SMS enviado com sucesso");
        }
    )
    .catch(response=>{toast.info("Erro ao enviar o SMS");
}
    )
}

function NotificationButton({salesId} : Props) {
    return (
        <>
            <div className="dsmeta-red-btn" onClick={()=>handleClick(salesId)}>
                <img src={icon} alt="Notificar" />
            </div>
        </>
    )
}

export default NotificationButton