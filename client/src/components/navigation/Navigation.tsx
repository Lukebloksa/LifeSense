import styles from "./Navigation.module.css"
import lightLogo from "../../assets/logo/lifesense_logo_light.png"

function Navigation() {
    return (
        <div className={styles.navigationContainer}>
            <div className={styles.navigationLogo}>
                <img src={lightLogo} alt="LifeSense Logo" className={styles.navigationLogoImage} />
            </div>
            <div className={styles.navigationLinks}>

            </div>
        </div>
    )
}